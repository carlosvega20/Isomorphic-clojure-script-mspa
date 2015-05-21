(ns home.action
 (:require  [reagent.core :as reagent :refer [atom]]
 			[home.state :as state]))

; Dispatchers

;Set the hiccup view as the current page
(defn set-page! [view]
	;Replace the current Hiccup view
	(reset! state/current-page-cursor view))