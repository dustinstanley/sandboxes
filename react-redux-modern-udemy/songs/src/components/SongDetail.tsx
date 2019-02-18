import React from 'react';
import {connect} from "react-redux";

class SongDetail extends React.Component<any, any> {
  render() {
    const song = this.props.song;
    if (!song) {
      return <div>Select a song</div>;
    }

    return (
      <div>
        <h3>Details for:</h3>
        <p>
          Title: {song.title}
          <br />
          Duration: {song.duration}
        </p>
      </div>
    );
  }
}

const mapStateToProps = (applicationState: any) => {
    return { song: applicationState.selectedSong };
};

export default connect(mapStateToProps)(SongDetail);