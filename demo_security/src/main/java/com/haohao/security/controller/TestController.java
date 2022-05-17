package com.haohao.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haohao
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/1")
    @PreAuthorize("@ss.hasPermission('page:test')")
    public String test1() {
        return "test1";
    }

    @GetMapping("/2")
    @PreAuthorize("@ss.hasAnyPermission('page:test')")
    public String test2() {
        return "test2";
    }

    @GetMapping("/3")
    @PreAuthorize("@ss.hasRole('test')")
    public String test3() {
        return "test3";
    }

    @GetMapping("/4")
    @PreAuthorize("@ss.hasAnyRole('test')")
    public String test4() {
        return "test4";
    }
}
