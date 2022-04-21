import {requireNativeComponent, ViewProps} from 'react-native';
import {Product} from '../../types';

interface NativeComponentProps {
  data: Product[];
  refreshing: boolean;
}

type NativeListProps = ViewProps & NativeComponentProps;

export const NativeList = requireNativeComponent<NativeListProps>('nativeList');
