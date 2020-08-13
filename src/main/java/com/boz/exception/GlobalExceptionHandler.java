package com.boz.exception;

import com.boz.bean.JSONResult;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String ERROR_VIEW = "error";


    @ExceptionHandler(MultipartException.class)
    public Object errorHander2(MultipartException e, RedirectAttributes redirectAttributes){


        FileUploadBase.SizeLimitExceededException sizeLimitExceededException = (FileUploadBase.SizeLimitExceededException) e.getCause().getCause();
        System.out.println(sizeLimitExceededException.getActualSize());
        System.out.println(sizeLimitExceededException.getPermittedSize());

        long fileSize = sizeLimitExceededException.getActualSize();
        long maxSize = sizeLimitExceededException.getPermittedSize();

        //第一种RedirectAttributes.addAttribute("param", value);
        //这种方式就相当于重定向之后，在url后面拼接参数，这样在重定向之后的页面或者控制器再去获取url后面的参数就可以了，但这个方式因为是在url后面添加参数的方式，所以暴露了参数，有风险
        //第二种RedirectAttributes.addFlashAttribute("param", value);
        //这种方式也能达到重新向带参，而且能隐藏参数，其原理就是放到session中，session在跳到页面后马上移除对象。所以你刷新一下后这个值就会丢掉
        if(fileSize > maxSize){
            redirectAttributes.addFlashAttribute("message","文件超过最大限制，最大限制" + maxSize/1024/1024 +"Mb");
        }else{
            redirectAttributes.addFlashAttribute("message",e.getCause().getMessage());
        }


        return "redirect:/upload/showStatus";
    }




    @ExceptionHandler
    @ResponseBody
    public Object errorHander( MissingServletRequestParameterException exception){
        return JSONResult.errorMsg("参数" + exception.getParameterName() + "不能为空！");
    }

    @ExceptionHandler
    @ResponseBody
    public Object errUrl(NoHandlerFoundException exception){
        return JSONResult.errorMsg("接口地址" + exception.getRequestURL() + "不存在！");
    }


/*
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception{
        e.printStackTrace();
        if(isAjax(request)){
            return JSONResult.errorException(e.getMessage());
        }else{
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", request.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }
*/

    private static boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }
}
