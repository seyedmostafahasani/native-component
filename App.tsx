import { StyleSheet, View } from 'react-native';
import React, { useEffect, useState } from 'react';
import { NativeList } from './nativeModules/list';
import { Product } from './types';
import axios from 'axios';
const styles = StyleSheet.create({
  full: {
    flex: 1,
  },
});

const App = () => {
  const [products, setProducts] = useState<Product[]>([]);

  useEffect(() => {
    axios.get("https://dummyjson.com/products").then(response => {
      setProducts(response.data.products);
    }).catch(error => console.log({ error }))
  }, [])

  return (
    <NativeList data={products} style={styles.full} />
  );
};

export default App;
