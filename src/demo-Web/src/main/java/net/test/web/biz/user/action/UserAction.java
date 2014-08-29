/*
 * Copyright 2008-2009 the original 赵永春(zyc@hasor.net).
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
package net.test.web.biz.user.action;
import net.hasor.mvc.MappingTo;
import net.hasor.mvc.web.AbstractWebController;
import net.hasor.mvc.web.restful.Get;
import net.hasor.mvc.web.restful.Post;
import net.hasor.mvc.web.restful.QueryParam;
import net.hasor.mvc.web.result.Redirect;
/**
 * View层控制器
 * http://localhost:8080/user/execute.do
 * @version : 2014年8月27日
 * @author 赵永春(zyc@hasor.net)
 */
public class UserAction extends AbstractWebController {
    @Redirect
    @Get
    @MappingTo("/user.do")
    public String doPost(@QueryParam("userID") String userID) {
        System.out.println(userID);
        //
        return "http://www.baidu.com";
    }
    @Post
    @MappingTo("/user.do")
    public void doGet(@QueryParam("userID") String userID) {
        System.out.println(userID);
        // TODO Auto-generated method stub
    }
}