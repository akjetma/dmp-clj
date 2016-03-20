# dmp-clj

Easy peasy way to use [Google's diff match patch library](https://code.google.com/archive/p/google-diff-match-patch/) in your Clojure or ClojureScript project.

```clojure
;; leiningen
[akjetma/dmp-clj "0.1.1"]
```
* * *

```clojure
(require '[dmp-clj.core :as dmp])

(def old "cat")
(def new "cats")
(def patch (dmp/make-patch old new))
(def patched (dmp/apply-patch old patch))
```

This is what patch looks like when `println`'d. 
```
@@ -1,3 +1,4 @@
 cat
+s

```
`dmp/make-patch` computes the patch and converts it into its string representation.

Conversely, `dmp/apply-patch` takes a patch string rather than the implementation-specific patch object.
```clojure
(= (dmp/apply-patch old patch) new)
true
```
