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

import java.io.InputStream;
import java.util.Properties;

/**
 * Create a git properties object from the expected property file.
 * @author Grégory Van den Borre
 */
public class GitPropertiesProvider {

    /**
     * Private constructor to prevent instantiation.
     */
    private GitPropertiesProvider() {
        super();
    }

    /**
     * Create a git property object from a git property file..
     * If the file cannot be found, a technical exception will be raised.
     * @return The GitProperties fulfilled object.
     */
    public static GitProperties getGitProperties()  {
        try(InputStream is = GitPropertiesProvider.class.getClassLoader().getResourceAsStream("git.properties")) {
            Properties p = new Properties();
            if(is == null) {
                p.setProperty("git.branch", "none");
                p.setProperty("git.build.host", "none");
                p.setProperty("git.build.time", "none");
                p.setProperty("git.build.user.email", "none");
                p.setProperty("git.build.user.name", "none");
                p.setProperty("git.build.version", "none");
                p.setProperty("git.closest.tag.commit.count", "none");
                p.setProperty("git.closest.tag.name", "none");
                p.setProperty("git.commit.id", "none");
                p.setProperty("git.commit.id.abbrev", "none");
                p.setProperty("git.commit.id.describe", "none");
                p.setProperty("git.commit.id.describe-short", "none");
                p.setProperty("git.commit.message.full", "none");
                p.setProperty("git.commit.message.short", "none");
                p.setProperty("git.commit.time", "none");
                p.setProperty("git.commit.user.email", "none");
                p.setProperty("git.commit.user.name", "none");
                p.setProperty("git.dirty", "none");
                p.setProperty("git.remote.origin.url", "none");
                p.setProperty("git.tags", "none");
            } else {
                p.load(is);
            }
            return new GitProperties(p);
        } catch (Exception e) {
            throw new GitPropertiesException(e);
        }
    }

}
