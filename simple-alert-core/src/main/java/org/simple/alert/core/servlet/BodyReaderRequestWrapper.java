package org.simple.alert.core.servlet;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luke
 * @date 2021/12/25 14:51
 * @desc http读取body
 **/
public class BodyReaderRequestWrapper extends HttpServletRequestWrapper {

    private final String body;

    /**
     * @param request
     */
    public BodyReaderRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        StringBuilder sb = new StringBuilder();
        InputStream ins = request.getInputStream();
        BufferedReader isr = null;
        try {
            if (ins != null) {
                isr = new BufferedReader(new InputStreamReader(ins));
                char[] charBuffer = new char[128];
                int readCount = 0;
                while ((readCount = isr.read(charBuffer)) != -1) {
                    sb.append(charBuffer, 0, readCount);
                }
            } else {
                sb.append("");
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (isr != null) {
                isr.close();
            }
        }

        sb.toString();
        body = sb.toString();
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream byteArrayIns = new ByteArrayInputStream(body.getBytes());
        ServletInputStream servletIns = new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return byteArrayIns.read();
            }
        };
        return servletIns;
    }

    public String getBody() {
        return this.body;
    }

    /**
     * 获取客户端请求参数中所有的信息
     *
     * @return
     */
    public Map<String, Object> getAllRequestParam() {
        Map<String, Object> res = new HashMap();
        Enumeration<?> temp = getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = getParameter(en);
                res.put(en, value);
                //如果字段的值为空，判断若值为空，则删除这个字段>
                if (null == res.get(en) || "".equals(res.get(en))) {
                    res.remove(en);
                }
            }
        }
        return res;
    }

    /**
     * 获取客户端请求头中所有的信息
     *
     * @return
     */
    public Map<String, Object> getAllHeader() {
        Map<String, Object> res = new HashMap();
        Enumeration<?> temp = getHeaderNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = getHeader(en);
                res.put(en, value);
                //如果字段的值为空，判断若值为空，则删除这个字段>
                if (null == res.get(en) || "".equals(res.get(en))) {
                    res.remove(en);
                }
            }
        }
        return res;
    }
}
