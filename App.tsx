import { DeviceEventEmitter, StyleSheet, View } from 'react-native';
import React, { useEffect, useState } from 'react';
import { NativeList } from './nativeComponents/list';
import { Product } from './types';
import axios from 'axios';
const styles = StyleSheet.create({
  full: {
    flex: 1,
  },
});

const App = () => {
  const [products, setProducts] = useState<Product[]>([]);
  const [refreshing, setRefreshing] = useState(false);

  const getProduct = async () => {
    setRefreshing(true);
    try {
      const response = await axios.get("https://dummyjson.com/products");
      setProducts(response.data.products);
    } catch (error) {
      console.log({ error })
    }
    setRefreshing(false);
  }

  useEffect(() => {
    getProduct();
    DeviceEventEmitter.addListener("refreshFeed", () => getProduct());

    return () => {
      DeviceEventEmitter.removeAllListeners();
    }
  }, [])

  return (
    <NativeList data={products} refreshing={refreshing} style={styles.full} />
  );
};

export default App;
