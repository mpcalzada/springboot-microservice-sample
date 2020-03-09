package com.mcalzada.springboot.app.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * {@link PostTiempoTranscurridoFilter}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter
{
    private static final Logger log = LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);

    @Override
    public String filterType()
    {
        return "post";
    }

    @Override
    public int filterOrder()
    {
        return 1;
    }

    @Override
    public boolean shouldFilter()
    {
        return true;
    }

    @Override
    public Object run() throws ZuulException
    {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        log.info("Entrando a post filter");

        Long tiempoInicio = (long) request.getAttribute("tiempoInicio");
        Long tiempoFinal = System.currentTimeMillis();
        Long tiempoTranscurrido = tiempoFinal - tiempoInicio;

        log.info(String.format("Tiempo transcurridos en milis: %s", tiempoTranscurrido));
        log.info(String.format("Tiempo transcurridos en sec: %s", tiempoTranscurrido / 1000));

        return null;
    }
}
