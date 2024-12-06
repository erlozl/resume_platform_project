package com.example.resume_platform.utils;

public class Script {

    public static String back(String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append("<script>");
        sb.append("alert('" + msg + "')");
        sb.append("history.back();");
        sb.append("</script>");
        return sb.toString();
    }

    // 이동
    public static String href(String url) {
        StringBuilder sb = new StringBuilder();
        sb.append("<script>");
        sb.append("location.href='" + url + "';");
        sb.append("</script>");
        return sb.toString();
    }

    public static String href(String url, String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append("<script>");
        sb.append("alert('" + msg + "');");
        sb.append("location.href='" + url + "';");
        sb.append("</script>");
        return sb.toString();
    }
}
