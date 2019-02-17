import React from 'react';
import ImageCard from './ImageCard';
import './ImageList.css';

interface Image {
  description: string,
  id: string,
  urls: {
    regular: string
  }
}
interface ImageListProps {
  images: Array<Image>
}

const ImageList = (props: ImageListProps) => {
  const images = props.images.map((image) => {
    return <ImageCard key={image.id} image={image} />
  });
  return <div className={"image-list"}>{images}</div>
};

export default ImageList;