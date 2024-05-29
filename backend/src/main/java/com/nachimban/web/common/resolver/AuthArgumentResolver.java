package com.nachimban.web.common.resolver;

import com.nachimban.web.auth.support.BearerAuthorizationExtractor;
import com.nachimban.web.auth.support.JwtTokenProvider;
import com.nachimban.web.common.security.AuthorizedMember;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class AuthArgumentResolver implements HandlerMethodArgumentResolver {

    private final BearerAuthorizationExtractor bearerAuthorizationExtractor;
    private final JwtTokenProvider jwtTokenProvider;


    public AuthArgumentResolver(
            BearerAuthorizationExtractor bearerAuthorizationExtractor,
            JwtTokenProvider jwtTokenProvider
    ) {
        this.bearerAuthorizationExtractor = bearerAuthorizationExtractor;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return AuthorizedMember.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        String accessToken = bearerAuthorizationExtractor.extract(request);
        String memberId = jwtTokenProvider.getPayload(accessToken);

        return new AuthorizedMember(Long.parseLong(memberId));
    }

}
