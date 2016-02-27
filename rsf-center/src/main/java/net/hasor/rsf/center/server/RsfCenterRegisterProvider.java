/*
 * Copyright 2008-2009 the original author or authors.
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
package net.hasor.rsf.center.server;
import org.hsqldb.lib.MD5;
import net.hasor.rsf.center.RsfCenterRegister;
import net.hasor.rsf.center.domain.PublishInfo;
/**
 * @version : 2015年6月8日
 * @author 赵永春(zyc@hasor.net)
 */
public class RsfCenterRegisterProvider implements RsfCenterRegister {
    @Override
    public String publishService(String hostString, PublishInfo info) {
        // TODO Auto-generated method stub
        return MD5.encode(info.getBindID(), "UTF-8");
    }
    @Override
    public String receiveService(String hostString, PublishInfo info) {
        // TODO Auto-generated method stub
        return MD5.encode(info.getBindID(), "UTF-8");
    }
    @Override
    public boolean removeRegister(String hostString, String registerID) {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean[] serviceBeat(String hostString, String[] registerID) {
        boolean[] res = new boolean[registerID.length];
        for (int i = 0; i < res.length; i++)
            res[i] = true;
        return res;
    }
    @Override
    public String repairPublishService(String hostString, String oldRegisterID, PublishInfo info) {
        // TODO Auto-generated method stub
        return MD5.encode(info.getBindID(), "UTF-8");
    }
    @Override
    public String repairReceiveService(String hostString, String oldRegisterID, PublishInfo info) {
        // TODO Auto-generated method stub
        return MD5.encode(info.getBindID(), "UTF-8");
    }
}