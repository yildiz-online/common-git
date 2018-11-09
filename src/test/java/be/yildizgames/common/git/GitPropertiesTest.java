/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2018 Grégory Van den Borre
 *
 *  More infos available: https://www.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 */

package be.yildizgames.common.git;

import be.yildizgames.common.git.exception.GitPropertiesException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Properties;

/**
 * @author Grégory Van den Borre
 */
class GitPropertiesTest {

    @Test
    void checkNullParameter() {
        Assertions.assertThrows(GitPropertiesException.class, () -> new GitProperties(null));
    }

    @Test
    void checkProperties() {
        Properties p = givenAProperties();
        GitProperties gitProperties = new GitProperties(p);
        Assertions.assertEquals("myBranch", gitProperties.getBranch());
        Assertions.assertEquals("myHost", gitProperties.getHost());
        Assertions.assertEquals("myTime", gitProperties.getBuildTime());
        Assertions.assertEquals("myEmail", gitProperties.getUserEmail());
        Assertions.assertEquals("myName", gitProperties.getUserName());
        Assertions.assertEquals("myVersion", gitProperties.getVersion());
        Assertions.assertEquals("myCount", gitProperties.getClosestTagCommitCount());
        Assertions.assertEquals("myTagName", gitProperties.getClosesTagName());
        Assertions.assertEquals("myId", gitProperties.getCommitId());
        Assertions.assertEquals("myAbrev", gitProperties.getCommitIdAbrev());
        Assertions.assertEquals("myDescribe", gitProperties.getCommitIdDescribe());
        Assertions.assertEquals("myDescribeShort", gitProperties.getCommitIdDescribeShort());
        Assertions.assertEquals("myFullMessage", gitProperties.getCommitMessageFull());
        Assertions.assertEquals("myShortMessage", gitProperties.getCommitMessageShort());
        Assertions.assertEquals("myCommitTime", gitProperties.getCommitTime());
        Assertions.assertEquals("myCommitEmail", gitProperties.getCommiterEmail());
        Assertions.assertEquals("myCommitName", gitProperties.getCommiter());
        Assertions.assertEquals("isDirty", gitProperties.getDirty());
        Assertions.assertEquals("myUrl", gitProperties.getOrigin());
        Assertions.assertEquals("myTags", gitProperties.getTags());
    }

    @Test
    void checkEmptyProperties() {
        Properties p = new Properties();
        GitProperties gitProperties = new GitProperties(p);
        Assertions.assertEquals("Unknown", gitProperties.getBranch());
        Assertions.assertEquals("Unknown", gitProperties.getHost());
        Assertions.assertEquals("Unknown", gitProperties.getBuildTime());
        Assertions.assertEquals("Unknown", gitProperties.getUserEmail());
        Assertions.assertEquals("Unknown", gitProperties.getUserName());
        Assertions.assertEquals("Unknown", gitProperties.getVersion());
        Assertions.assertEquals("Unknown", gitProperties.getClosestTagCommitCount());
        Assertions.assertEquals("Unknown", gitProperties.getClosesTagName());
        Assertions.assertEquals("Unknown", gitProperties.getCommitId());
        Assertions.assertEquals("Unknown", gitProperties.getCommitIdAbrev());
        Assertions.assertEquals("Unknown", gitProperties.getCommitIdDescribe());
        Assertions.assertEquals("Unknown", gitProperties.getCommitIdDescribeShort());
        Assertions.assertEquals("Unknown", gitProperties.getCommitMessageFull());
        Assertions.assertEquals("Unknown", gitProperties.getCommitMessageShort());
        Assertions.assertEquals("Unknown", gitProperties.getCommitTime());
        Assertions.assertEquals("Unknown", gitProperties.getCommiterEmail());
        Assertions.assertEquals("Unknown", gitProperties.getCommiter());
        Assertions.assertEquals("Unknown", gitProperties.getDirty());
        Assertions.assertEquals("Unknown", gitProperties.getOrigin());
        Assertions.assertEquals("Unknown", gitProperties.getTags());
    }

    private static Properties givenAProperties() {
        Properties p = new Properties();
        p.setProperty("git.branch", "myBranch");
        p.setProperty("git.build.host", "myHost");
        p.setProperty("git.build.time", "myTime");
        p.setProperty("git.build.user.email", "myEmail");
        p.setProperty("git.build.user.name", "myName");
        p.setProperty("git.build.version", "myVersion");
        p.setProperty("git.closest.tag.commit.count", "myCount");
        p.setProperty("git.closest.tag.name", "myTagName");
        p.setProperty("git.commit.id", "myId");
        p.setProperty("git.commit.id.abbrev", "myAbrev");
        p.setProperty("git.commit.id.describe", "myDescribe");
        p.setProperty("git.commit.id.describe-short", "myDescribeShort");
        p.setProperty("git.commit.message.full", "myFullMessage");
        p.setProperty("git.commit.message.short", "myShortMessage");
        p.setProperty("git.commit.time", "myCommitTime");
        p.setProperty("git.commit.user.email", "myCommitEmail");
        p.setProperty("git.commit.user.name", "myCommitName");
        p.setProperty("git.dirty", "isDirty");
        p.setProperty("git.remote.origin.url", "myUrl");
        p.setProperty("git.tags", "myTags");

        return p;
    }
}
