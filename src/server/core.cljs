(ns server.core
  (:require [reagent.core :as reagent :refer [atom]]
            [cljs.nodejs :as nodejs]
            [home.core :as home]
            [secretary.core :as secretary :refer-macros [defroute]]
            [cljs.reader :refer [read-string]]))

(nodejs/enable-util-print!)

(defonce express (nodejs/require "express"))
(defonce body-parser (nodejs/require "body-parser"))
(defonce http (nodejs/require "http"))

; load express
(def app (express))

(defn template [{:keys [app title body]}]
  [:html
   [:head
    [:meta {:charset "utf-8"}]
    [:title title]
    [:meta {:name    "viewport"
            :content "width=device-width, initial-scale=1.0"}]]
   [:body
    [:div#app [body]]
    [:script {:type "text/javascript" :src (str "../" app "/dev/goog/base.js")}]
    [:script {:type "text/javascript" :src (str "../" app "/dev/app.js")}]
    [:script {:type                    "text/javascript"
              :dangerouslySetInnerHTML {:__html (str "goog.require('" app ".core');")}}]
    ]])

(defn render-page [path]
  (reagent/render-to-static-markup (do
                                     (secretary/dispatch! path)
                                     (println path)
                                     (template {  :app "home" ;Replace this one with path "/path/" without the /
                                                :page "title"
                                                :body  home/view}))))

(defn handle-request [req res] 
  (.send res (render-page (.-path req))))

(. app (get "/home" handle-request))

(def -main (fn []
             (doto (.createServer http #(app %1 %2))
               (.listen 3000))))

(set! *main-cli-fn* -main)
