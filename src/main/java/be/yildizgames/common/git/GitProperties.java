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

import java.util.Properties;

public class GitProperties {

    private final String branch;

    private final String commiter;

    private final String version;

    private final String buildTime;

    private final String commitId;

    private final String commitTime;

    private final String commitMessageFull;
    private final String host;
    private final String userEmail;
    private final String userName;
    private final String closestTagCommitCount;
    private final String closesTagName;
    private final String commitIdAbrev;
    private final String commitIdDescribe;
    private final String commitIdDescribeShort;
    private final String commitMessageShort;
    private final String commiterEmail;
    private final String dirty;
    private final String origin;
    private final String tags;

    GitProperties(Properties p) {
        super();
        this.branch = getValue(p, "git.branch");
        this.host = getValue(p, "git.build.host");
        this.buildTime = getValue(p, "git.build.time");
        this.userEmail = getValue(p, "git.build.user.email");
        this.userName = getValue(p, "git.build.user.name");
        this.version = getValue(p, "git.build.version");
        this.closestTagCommitCount = getValue(p, "git.closest.tag.commit.count");
        this.closesTagName = getValue(p, "git.closest.tag.name");
        this.commitId = getValue(p, "git.commit.id");
        this.commitIdAbrev = getValue(p, "git.commit.id.abbrev");
        this.commitIdDescribe = getValue(p, "git.commit.id.describe");
        this.commitIdDescribeShort = getValue(p, "git.commit.id.describe-short");
        this.commitMessageFull = getValue(p, "git.commit.message.full");
        this.commitMessageShort = getValue(p, "git.commit.message.short");
        this.commitTime = getValue(p, "git.commit.time");
        this.commiterEmail = getValue(p, "git.commit.user.email");
        this.commiter = getValue(p, "git.commit.user.name");
        this.dirty = getValue(p, "git.dirty");
        this.origin = getValue(p, "git.remote.origin.url");
        this.tags = getValue(p, "git.tags");
    }

    public String getBranch() {
        return branch;
    }

    public String getCommiter() {
        return commiter;
    }

    public String getVersion() {
        return version;
    }

    public String getBuildTime() {
        return buildTime;
    }

    public String getCommitId() {
        return commitId;
    }

    public String getCommitTime() {
        return commitTime;
    }

    public String getCommitMessageFull() {
        return commitMessageFull;
    }

    public String getHost() {
        return host;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getClosestTagCommitCount() {
        return closestTagCommitCount;
    }

    public String getClosesTagName() {
        return closesTagName;
    }

    public String getCommitIdAbrev() {
        return commitIdAbrev;
    }

    public String getCommitIdDescribe() {
        return commitIdDescribe;
    }

    public String getCommitIdDescribeShort() {
        return commitIdDescribeShort;
    }

    public String getCommitMessageShort() {
        return commitMessageShort;
    }

    public String getCommiterEmail() {
        return commiterEmail;
    }

    public String getDirty() {
        return dirty;
    }

    public String getOrigin() {
        return origin;
    }

    public String getTags() {
        return tags;
    }

    private static String getValue(Properties p, String key) {
        return p.getProperty(key, "Unknown");
    }
}
