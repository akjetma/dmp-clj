# dmp-clj

Easy peasy way to use [Google's diff match patch library](https://code.google.com/archive/p/google-diff-match-patch/) in your Clojure or ClojureScript project.

```clojure
;; leiningen
[akjetma/dmp-clj "0.1.0"]
```
* * *  

```clojure
(require '[dmp-clj.core :as dmp])

(def old "cat")
(def new "cats")
(def patch (dmp/make-patch old new))
(println patch) 
```

```
@@ -1,3 +1,4 @@
 cat
+s

```
  

```clojure
(println (dmp/apply-patch old patch))
```

```
cats
```

