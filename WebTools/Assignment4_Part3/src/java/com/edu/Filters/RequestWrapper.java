/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.Filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 *
 * @author ujjva
 */
public class RequestWrapper extends HttpServletRequestWrapper {

    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        if (values == null) {
            return null;
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = sanitize(values[i]);
        }
        return encodedValues;
    }
    
    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        return sanitize(value);
    }
    
    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        return sanitize(value);
    }

    public static String sanitize(String s) {
        if (s == null) {
            return null;
        }
        String temp = s;
        temp = temp.replaceAll("<[^>]*>", " ");
        temp = temp.replaceAll("[\\&;`'\\\\\\|\"*?%@!~<>^\\(\\)\\[\\]\\{\\}\\$\\x00]", "");
        temp = temp.replaceAll("\n", " ").replace("\r", " ").replace("\t", " ");
        temp = temp.replaceAll("\\s+", " ").trim();
        return temp;
    }
}
