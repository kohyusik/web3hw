package net.bitacademy.java67.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
  FilterConfig config;

  @Override
  public void init(FilterConfig config) throws ServletException {
    this.config = config; // 잘 보관하라!!
  }
  
  @Override
  public void destroy() {}

  @Override
  public void doFilter(
      ServletRequest request, ServletResponse response,
      FilterChain chainManager) throws IOException, ServletException {

    String encoding = config.getInitParameter("encoding");
    if (encoding == null) 
      encoding = "UTF-8"; //기본 인코딩 설정
    
    request.setCharacterEncoding(encoding);
    
    chainManager.doFilter(request, response);
  }


}
















