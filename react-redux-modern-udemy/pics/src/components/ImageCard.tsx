import React from 'react';

interface ImageCardProps {
  image: {
    description: string
    urls: {
      regular: string
    }
  }
}

interface ImageCardState {
  spans: number
}

export default class ImageCard extends React.Component<ImageCardProps, ImageCardState> {
  private readonly imageRef: React.RefObject<any>;

  constructor(props: ImageCardProps) {
    super(props);

    this.state = { spans: 0 };

    this.imageRef = React.createRef();
  }

  componentDidMount() {
    this.imageRef.current.addEventListener('load', this.calculateRowSpan);
  }

  /**
   * Calculate how many row spans the image should cover.
   * This will be used to set the 'grid-row-end' css property on the containing div for the image.
   *
   * Called via the 'load' event listener for the corresponding img element.
   */
  calculateRowSpan = () => {
    const height = this.imageRef.current.clientHeight;
    const spans = Math.ceil(height / 10);

    this.setState({ spans });
  };

  render() {
    const { description, urls } = this.props.image;

    return (
      <div style={{ gridRowEnd: `span ${this.state.spans}` }}>
        <img ref={this.imageRef} alt={description} src={urls.regular} />
      </div>
    )
  }
}