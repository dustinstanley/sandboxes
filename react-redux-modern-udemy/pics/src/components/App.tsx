import React from 'react';
import unsplash from '../api/unsplash';
import ImageList from './ImageList';
import SearchBar from './SearchBar';

interface AppState {
  images: Array<any>
}

class App extends React.Component<any, AppState> {
  constructor(props: any) {
    super(props);

    this.state = { images: [] };
  }

  onSearchSubmit = async (term: string) => {
    const response = await unsplash.get('/search/photos', {
      params: {
        query: term
      }
    });

    this.setState({ images: response.data.results });
  };

  render() {
    return(
      <div className={"ui container"} style={{marginTop: '10px'}}>
        <SearchBar onSubmitCallback={this.onSearchSubmit}/>
        <ImageList images={this.state.images} />
      </div>
    );
  }
}

export default App;