/*
 * Copyright 2008-2009 the original ������(zyc@hasor.net).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.hasor.web.servlet.anno;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.servlet.http.HttpServlet;
/**
 * ����һ��Servlet����Servlet��Ҫ�̳�{@link HttpServlet}�ࡣ
 * @version : 2013-3-12
 * @author ������ (zyc@hasor.net)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface WebServlet {
    /**Servlet�ڹ��������ϵ�˳��Ĭ�ϣ�0������Խ������Խ�ӳ١�
     * <br/><b>ע��</b><i>��ֵ����ͨ����������̨���������á�</i>*/
    public int loadOnStartup() default 0;
    /** ���������������
     * <br/><b>ע��</b><i>��ֵ����ͨ����������̨���������á�</i>*/
    public WebInitParam[] initParams() default {};
    /**URLƥ�����*/
    public String[] value();
    /**URL�����Ƿ�ʹ���������ʽ��ʽ��д��*/
    public boolean regex() default false;
    /**Servlet����*/
    public String servletName() default "";
}