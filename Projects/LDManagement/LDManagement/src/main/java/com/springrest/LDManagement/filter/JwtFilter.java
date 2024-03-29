//package com.springrest.LDManagement.filter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class JwtFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private JwtUtility jwtUtility;
//
//    @Autowired
//    private CustomUserDetailService userService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//        String authorization = httpServletRequest.getHeader("Authorization");
//        String token = null;
//        String userName = null;
//
//        if ((authorization != null) && (authorization.startsWith("Bearer "))) {
//            token = authorization.substring(7);
//            userName = jwtUtility.getUsernameFromToken(token);
//        }
//
//        if ((userName != null) && (SecurityContextHolder.getContext().getAuthentication() == null)) {
//            UserDetails userDetails = userService.loadUserByUsername(userName);
//
//            if (jwtUtility.validateToken(token, userDetails)) {
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
//                        = new UsernamePasswordAuthenticationToken(userDetails,
//                        null, userDetails.getAuthorities());
//
//                usernamePasswordAuthenticationToken.setDetails(
//                        new WebAuthenticationDetailsSource().buildDetails(httpServletRequest)
//                );
//
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//            }
//
//        }
//        filterChain.doFilter(httpServletRequest, httpServletResponse);
//    }
//
//}
