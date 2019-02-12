import React from 'react';

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
  const images = props.images.map(({description, id, urls}) => {
    return <img key={id} alt={description} src={urls.regular}/>
  });
  return <div>{images}</div>
};

export default ImageList;