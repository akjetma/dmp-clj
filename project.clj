(defproject dmp-clj "0.1.0-SNAPSHOT"
  :author "Adam Jetmalani <https://akjetma.github.io>"
  :description "comprehensive clojure/clojurescript wrapper for google's diff match patch library"
  :url "http://github.com/akjetma/dmp-clj"  
  :scm {:name "git"
        :url "http://github.com/akjetma/dmp-clj"}

  :min-lein-version "2.5.3"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.7.228"]]
  :plugins [[lein-cljsbuild "1.1.2"]]
  :clean-targets ^{:protect false} ["target" "test.js"]
  :source-paths ["src"]
  :java-source-paths ["libs/java"]
  :cljsbuild {:builds {:main {:source-paths ["src"]
                              :compiler {:output-to "target/main.js"
                                         :optimizations :advanced
                                         :pretty-print false
                                         :externs ["libs/javascript/dmp_externs.js"]
                                         :foreign-libs [{:file "libs/javascript/dmp.js"
                                                         :provides ["dmp.lib"]}]}}
                       :test {:source-paths ["src" "test"]
                              :compiler {:main "dmp-clj.cljs-test"
                                         :output-to "test.js"
                                         :optimizations :advanced
                                         :pretty-print false
                                         :externs ["libs/javascript/dmp_externs.js"]
                                         :foreign-libs [{:file "libs/javascript/dmp.js"
                                                         :provides ["dmp.lib"]}]}}}})
