(defproject home "v1"
  :description "SPA Home"

  :dependencies [[org.clojure/clojure "1.6.0"]
  				      [org.clojure/clojurescript "0.0-3208"]
                [reagent "0.5.0"]
                [cljs-ajax "0.3.11"]
                [secretary "1.2.3"]
                [kibu/pushy "0.3.1"]
                [hickory "0.5.4"]
                [hiccup "1.0.5"]
                [compojure "1.3.3"]
                [selmer "0.8.2"]]

  :aliases {"dev"      ["do" "cljsbuild" "auto" "dev"]
            "dev-once" ["do" "cljsbuild" "once" "dev"]
            "prod"     ["do" "cljsbuild" "once" "prod"]
            "build"    ["do" "dev-once"  "prod"]}

  :plugins [[lein-cljsbuild "1.0.5"]
            [com.cemerick/clojurescript.test "0.3.3"]]

  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src"]
                        :compiler {:optimizations :none
                                   :output-to "../../../resources/public/home/dev/app.js"
                                   :output-dir "../../../resources/public/home/dev/"
                                   :source-map true}}

                        {:id "prod"
                        :source-paths ["src"]
                        :compiler {:optimizations :simple
                                   :output-to "../../../resources/public/home/prod/app.js"
                                   :pretty-print false}}]}
  :min-lein-version "2.5.0")
