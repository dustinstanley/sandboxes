import React from 'react';
import { connect } from 'react-redux';
import { selectSong } from '../actions';
import {Song} from "../MyTypes";

interface SongListProps {
  songs: Array<Song>,
  selectSong: any
}

class SongList extends React.Component<any, any> {
  renderList(): Array<JSX.Element> {
    return this.props.songs.map((song: Song) => {
      return (
        <div className={"item"} key={song.title}>
          <div className={"right floated content"}>
            <button className={"ui button primary"} onClick={() => this.props.selectSong(song)}>
              Select
            </button>
          </div>

          <div className={"content"}>{song.title}</div>
        </div>
      );
    });
  }

  render() {
    console.log(this.props);
    return <div className={"ui divided list"}>{this.renderList()}</div>;
  }
}

/**
 * Narrows the full application state to just the list of songs and returns only the songs portion of the state.
 * This will be sent to the component as props.
 * @param applicationState the complete state of the application store
 */
const mapStateToProps = (applicationState: any): any => {
  console.log(applicationState);
  return { songs: applicationState.songs };
};

/**
 * Maps the 'selectSong' Action Creator to a component property.  Will be sent to the component as props.
 * When the selectSong function is invoked on the component property, it will automatically dispatch the action
 * to the redux store.
 */
const mapDispatchToProps = () => {
  return {selectSong: selectSong};
};

export default connect(mapStateToProps, mapDispatchToProps())(SongList);