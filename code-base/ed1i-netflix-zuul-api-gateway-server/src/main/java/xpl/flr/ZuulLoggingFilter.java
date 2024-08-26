package xpl.flr;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static xpl.uty.Colors.*;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
   private Logger logger = LoggerFactory.getLogger(this.getClass());

   @Override
   public String filterType() {
      // pre, post, error
      // pre: before routing
      // post: after routing
      // error: error
      // why pre, post, error? 
      // because we can do something before routing, after routing, or when error occurs
      return "pre";
   }

   @Override
   public int filterOrder() {
      // if we have multiple filters, we can set the order
      return 1;
   }

   @Override
   public boolean shouldFilter() {
      // if we want to filter, return true
      return true;
   }

   @Override
   public Object run() throws ZuulException {
      HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
      logger.warn(request.getRequestURI());
      logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
      pb(request + " => " + request.getRequestURI());
      logger.info("Parameters: ");
      request.getParameterMap().forEach((key, value) ->
              logger.info("{}: {}", key, String.join(", ", value))
      );
      // return null means we don't want to do anything
      // if we want to do something, we can return some value
      // for example, we can return request or response object so that  // other filters can use it to do something with it 
      // is it filter chaining?
      // yes, we can chain multiple filters
      // we can manipulate the request, response, etc
      return null;
   }
}
