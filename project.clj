(defproject bostonaholic/ring-okta "0.4.1-SNAPSHOT"
  :description "Ring middleware for Okta Single Sign-on"
  :url "https://github.com/bostonaholic/ring-okta"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories {"local" ~(str (.toURI (java.io.File. "maven_repository")))}
  :dependencies [[org.clojure/clojure "1.10.1" :scope "provided"]
                 [org.clojure/core.incubator "0.1.4"]
                 [ring/ring-core "1.8.1" :scope "provided" :exclusions [commons-codec]]
                 [ring-mock "0.1.5" :scope "test"]
                 [compojure "1.6.2" :exclusions [org.clojure/clojure commons-codec joda-time]]
                 [org.clojure/data.codec "0.1.1"]
                 [com.okta/saml-toolkit "1.0.12-000170-c7ed721" :upgrade :okta]

                 ;; okta dependencies -- some are not specified in their pom,
                 ;; others are borked because of our weird local repo thing that
                 ;; we do in order to please the Travis-CI gods
                 ;; FIXME: check if local repo is needed on CircleCI
                 [com.sun.xml.parsers/jaxp-ri "1.4.5" :upgrade :okta]
                 [org.slf4j/slf4j-api "1.6.1" :scope "provided" :upgrade :okta]
                 [org.slf4j/slf4j-simple "1.6.1" :scope "test" :upgrade :okta]
                 [com.google.inject/guice "3.0" :upgrade :okta]
                 [org.bouncycastle/bcprov-jdk16 "1.45" :upgrade :okta]
                 [org.apache.commons/commons-lang3 "3.0" :upgrade :okta]
                 [javax.servlet/javax.servlet-api "3.0.1" :scope "provided" :upgrade :okta]
                 [org.opensaml/opensaml "2.6.4" :upgrade :okta]]

  :pedantic? :abort

  :plugins [[lein-ancient "0.6.15"]
            [lein-codox "0.10.7"]
            [lein-cloverage "1.2.0"]]

  :codox {:namespaces [ring.middleware.okta]
          :output-path "./docs"
          :source-uri "https://github.com/bostonaholic/ring-okta/blob/v{version}/{filepath}#L{line}"}

  :profiles {:dev {:resource-paths ["test-resources"]
                   :dependencies [[cloverage "1.2.0"]]}
             :1.8 {:resource-paths ["test-resources"]
                   :dependencies [[org.clojure/clojure "1.8.0"]]}
             :1.9 {:resource-paths ["test-resources"]
                   :dependencies [[org.clojure/clojure "1.9.0"]]}
             :1.10 {:resource-paths ["test-resources"]
                   :dependencies [[org.clojure/clojure "1.10.1"]]}}

  :aliases {"test-all-profiles" ["with-profile" "dev:1.8:1.9:1.10" "test"]
            "cloverage" ["do" "cloverage" "--output" "docs/coverage"]
            "release" ["do" "clean," "deploy" "clojars"]})
