(ns dmp-clj.cljs-test
  (:require [dmp-clj.core :as dmp]))

(enable-console-print!)

(defn example-data
  []
  (let [shadow "cat"
        text "cats"
        patch (dmp/make-patch shadow text)
        updated (dmp/apply-patch shadow patch)]
    {:shadow shadow
     :text text
     :patch patch
     :updated updated}))

(defn run
  []
  (println (example-data)))

(run)
