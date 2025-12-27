String token = authHeader.substring(7);
String username = jwtUtil.extractUsername(token);

if (username != null &&
    SecurityContextHolder.getContext().getAuthentication() == null) {

    UserDetails userDetails =
            userDetailsService.loadUserByUsername(username);

    if (jwtUtil.validateToken(token, userDetails)) {

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
    }
}
