(defproject mspa "v.1.0"
  :description "Multi-Single-Page Applications (MSPA) using ClojureScript - Nodejs"
  :url "https://github.com/carlosvega20/Isomorphic-clojure-script-mspa"
  :resource-paths  ["resources" "build-resources"]

  :aliases {"server"  ["ring" "server"]
            "server-headless"  ["ring" "server-headless"]
            "build" ["do" ["clean"] ["compile"]]}

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-3208"]
                 [reagent "0.5.0"]
                 [cljs-ajax "0.3.11"]
                 [secretary "1.2.3"]
                [kibu/pushy "0.3.1"]
                [hickory "0.5.4"]]

  :plugins [[lein-cljsbuild "1.0.5"]
            [lein-modules "0.3.11"]
            [lein-npm "0.4.0"]]

  :node-dependencies [[express "4.10.7"]
                      [serve-static "1.9.1"]
                      [body-parser "1.12.0"]
                      [type-is "1.6.0"]
                      [ws "0.7.1"]]

  :modules {:subprocess "../../../lein"
              :dirs ["src/client/home" "src/client/products"]}

  :cljsbuild {
              :builds [{:id "server"
                        :source-paths ["src/client/products/src" "src/client/home/src" "src/server"]
                        :compiler {
                                   :output-to "server_out/todo_server.js"
                                   :output-dir "server_out"
                                   :target :nodejs
                                   :optimizations :none
                                   :cache-analysis true                                   
                                   :source-map true}}]}

  :min-lein-version "2.5.0")



