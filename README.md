# ring-okta

[![Build Status](https://travis-ci.org/Hendrick/ring-okta.svg?branch=master)](https://travis-ci.org/Hendrick/ring-okta) [![Dependency Status](https://www.versioneye.com/user/projects/540df18842c8d5146300000c/badge.svg)](https://www.versioneye.com/user/projects/540df18842c8d5146300000c)

Ring middleware for Okta Single Sign-on.

## Installation

### Leiningen

```
[ring-okta "0.1.0"]
```

### Gradle

```
compile "ring-okta:ring-okta:0.1.0"
```

### Maven

```
<dependency>
  <groupId>ring-okta</groupId>
  <artifactId>ring-okta</artifactId>
  <version>0.1.0</version>
</dependency
```

## Usage

```
(ns com.company.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.okta :refer [wrap-okta okta-routes]]))

(defroutes company-routes
  (GET "/" [] "<h1>Hello World</h1>")

  okta-routes

  (route/not-found "<h1>Page not found</h1>"))

(def app
  (-> company-routes
      (wrap-okta {:okta-home "https://company.okta.com"})))
```

## Documentation

- [API Docs](http://Hendrick.github.io/ring-okta/ring.middleware.okta.html)

The documentation is built with codox (`lein doc`) and published to
the [gh-pages](https://github.com/Hendrick/ring-okta/tree/gh-pages) branch.

## License

Copyright © 2014 Hendrick Automotive Group

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
