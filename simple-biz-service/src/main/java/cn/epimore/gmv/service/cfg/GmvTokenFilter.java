package cn.epimore.gmv.service.cfg;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class GmvTokenFilter implements Filter {
    private final GmvTokenConfig config;
    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    @Autowired
    public GmvTokenFilter(GmvTokenConfig config) {
        this.config = config;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;

            // 获取请求的路径
            String uri = httpRequest.getRequestURI();
            // 如果不需要验证，直接放行
            if (!config.getEnable()) {
                chain.doFilter(request, response);
                return;
            }

            // 白名单，直接放行
            if (CollectionUtils.isNotEmpty(config.getWhitelist()) && config.getWhitelist().stream().anyMatch(url -> pathMatcher.match(url, uri))) {
                chain.doFilter(request, response);
                return;
            }

            // 获取请求头中的 token
            String token = httpRequest.getHeader("Gmv-Token");

            // 验证 token
            if (!validateToken(token)) {
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpResponse.getWriter().write("Unauthorized: Invalid token");
                return;
            }
            // 将 token 存入 ThreadLocal，便于服务查找当前用户
            GmvTokenHolder.setToken(token);
            // 如果 token 验证通过，继续处理请求
            chain.doFilter(request, response);
        } finally {
            GmvTokenHolder.clear();
        }
    }

    private boolean validateToken(String token) {
        return GmvTokenHolder.checkToken(token);
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
