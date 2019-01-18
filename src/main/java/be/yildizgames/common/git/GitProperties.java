/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2019 Grégory Van den Borre
 *
 *  More infos available: https://engine.yildiz-games.be
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

import java.util.Properties;

/**
 * Data object built from a properties containing git information.
 * @author Grégory Van den Borre
 */
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
        if(p == null) {
            throw new GitPropertiesException("null parameter.");
        }
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

    public final String getBranch() {
        return branch;
    }

    public final String getCommiter() {
        return commiter;
    }

    public final String getVersion() {
        return version;
    }

    public final String getBuildTime() {
        return buildTime;
    }

    public final String getCommitId() {
        return commitId;
    }

    public final String getCommitTime() {
        return commitTime;
    }

    public final String getCommitMessageFull() {
        return commitMessageFull;
    }

    public final String getHost() {
        return host;
    }

    public final String getUserEmail() {
        return userEmail;
    }

    public final String getUserName() {
        return userName;
    }

    public final String getClosestTagCommitCount() {
        return closestTagCommitCount;
    }

    public final String getClosesTagName() {
        return closesTagName;
    }

    public final String getCommitIdAbrev() {
        return commitIdAbrev;
    }

    public final String getCommitIdDescribe() {
        return commitIdDescribe;
    }

    public final String getCommitIdDescribeShort() {
        return commitIdDescribeShort;
    }

    public final String getCommitMessageShort() {
        return commitMessageShort;
    }

    public final String getCommiterEmail() {
        return commiterEmail;
    }

    public final String getDirty() {
        return dirty;
    }

    public final String getOrigin() {
        return origin;
    }

    public final String getTags() {
        return tags;
    }

    private static String getValue(Properties p, String key) {
        return p.getProperty(key, "Unknown");
    }
}
