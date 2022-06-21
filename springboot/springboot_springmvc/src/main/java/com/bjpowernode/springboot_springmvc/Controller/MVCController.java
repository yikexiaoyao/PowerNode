package com.bjpowernode.springboot_springmvc.Controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author cty
 * @date 2021/12/12 14:24
 */
@RestController
public class MVCController {
    /**
     * 只支持request
     */
    @RequestMapping("/req")
    public Object req() {
        return "req";
    }

    /**
     * 只支持get
     */
    @GetMapping("/get")
    public Object get() {
        return "get";
    }

    /**
     * 只支持post
     */
    @PostMapping("/post")
    public Object post() {
        return "post";
    }

    /**
     * 只支持put
     */
    @PutMapping("/put")
    public Object put() {
        return "put";
    }

    /**
     * 只支持delete
     */
    @DeleteMapping("/delete")
    public Object delete() {
        return "delete";
    }
}
