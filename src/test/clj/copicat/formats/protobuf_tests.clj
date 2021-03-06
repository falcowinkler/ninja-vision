(ns copicat.formats.protobuf_tests
  (:require [clojure.test :refer :all]
            [copicat.formats.protobuf :as proto]
            [copicat.formats.nplusplus :as n++]
            [clojure.java.io :as io]))

(def test-tile-data
  (n++/get-tile-data-from-binary-file "resources/test"))

(deftest test-format-conversion
  (testing "if protobuf conversion works"
    (proto/serialize-to-file "test" test-tile-data)
    (is (= test-tile-data (proto/de-serialize-from-file "test.pb")))
    (io/delete-file "test.pb")))
