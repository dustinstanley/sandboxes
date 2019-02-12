import React from 'react';

interface SearchBarProps {
  onSubmitCallback: (term: string) => void
}

interface SearchBarState {
  term: string
}

class SearchBar extends React.Component<SearchBarProps, SearchBarState> {
  constructor(props: any) {
    super(props);

    this.state = { term: '' };
    this.onInputChange = this.onInputChange.bind(this);   //bind the event handling function below to "this" component
    this.onFormSubmit = this.onFormSubmit.bind(this);     //could alternatively use onFormSubmit = (event) => {...
  }

  onInputChange(event: React.FormEvent<HTMLInputElement>) {
    this.setState({ term: event.currentTarget.value });
  };

  onFormSubmit(event: React.FormEvent<HTMLFormElement>) {
    event.preventDefault();

    this.props.onSubmitCallback(this.state.term);
  }

  render() {
    return (
      <div className={"ui segment"}>
        <form onSubmit={this.onFormSubmit} className={"ui form"}>
          <div className={"field"}>
            <label>Image Search</label>
            <input type={"text"}
                   value={this.state.term}
                   onChange={this.onInputChange}/>
          </div>
        </form>
      </div>
    );
  }
}

export default SearchBar;