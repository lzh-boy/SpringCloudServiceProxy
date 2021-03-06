package com.example.demo.controller;


import com.zxj.cloud_service_proxy_core.util.LocalServiceAccessUtil;
import com.example.demo_service_interface.config.RemoteMicroServiceName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 调用服务层核心控制器，请勿修改此处代码！！！
 */
@Controller
public class ServiceInvokeCoreController {

    private static Logger logger = LoggerFactory.getLogger(ServiceInvokeCoreController.class);

    @Resource
    private ApplicationContext applicationContext;


    private static LocalServiceAccessUtil.Logger controllerLogger = info -> logger.info(info);

    @RequestMapping("/" + RemoteMicroServiceName.SERVICE_EVEYY_THING)
    public void everything(ServletRequest request, ServletResponse response) throws Throwable {
        InputStream inputStream = null;
        byte[] result = null;
        try {
            inputStream = request.getInputStream();
            result = LocalServiceAccessUtil.access(applicationContext, inputStream, controllerLogger);
        } finally {
            //TODO clear stream
            try {
                inputStream.close();
                inputStream = null;
            } catch (Exception e) {
            }
        }
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            if (result != null) outputStream.write(result);
        } finally {
            try {
                outputStream.flush();
            } catch (Exception e) {
            }
            try {
                outputStream.close();
            } catch (Exception e) {
            }
            outputStream = null;
        }
    }


}
