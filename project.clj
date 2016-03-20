(defproject akjetma/dmp-clj "0.1.1"
  :author "Adam Jetmalani <https://akjetma.github.io>"
  :description "comprehensive clojure/clojurescript wrapper for google's diff match patch library"
  :url "http://github.com/akjetma/dmp-clj"  
  :scm {:name "git"
        :url "http://github.com/akjetma/dmp-clj"}
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.5.3"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [cljsjs/google-diff-match-patch "20121119-0"]]
  :plugins [[lein-cljsbuild "1.1.2"]]
  :clean-targets ^{:protect false} ["target" "test.js"]
  :source-paths ["src"]
  :java-source-paths ["libs/java"]
  :cljsbuild {:builds {:main {:source-paths ["src"]
                              :compiler {:output-to "target/main.js"
                                         :optimizations :advanced
                                         :pretty-print false}}
                       :test {:source-paths ["src" "test"]
                              :compiler {:main "dmp-clj.cljs-test"
                                         :output-to "test.js"
                                         :optimizations :advanced
                                         :pretty-print false}}}})
