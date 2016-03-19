(ns dmp-clj.core
  #?(:clj (:import [name.fraser.neil.plaintext diff_match_patch diff_match_patch$Operation])
     :cljs (:require [dmp.lib])))

(defn diff-match-patch
  []
  #?(:clj (diff_match_patch.)
     :cljs (js/diff_match_patch.)))

(defonce _dmp (diff-match-patch))

(defn diff-main [t1 t2]
  (.diff_main _dmp t1 t2))

(defn cleanup!
  [diffs]
  (.diff_cleanupSemantic _dmp diffs)
  diffs)

(defn patch-make
  [t diffs]
  (.patch_make _dmp t diffs))

(defn patch-to-text
  [patches]
  (.patch_toText _dmp patches))

(defn patch-from-text
  [patch-text]
  (.patch_fromText _dmp patch-text))

(defn patch-apply
  [patches t]
  (.patch_apply _dmp patches t))

(defn make-patch [t1 t2]
  (->> (diff-main t1 t2)
      cleanup!
      (patch-make t1)
      patch-to-text))

(defn apply-patch [t patch]
  (first
   (patch-apply
    (patch-from-text patch)
    t)))
