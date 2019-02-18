// Action creator
export const selectSong = (song: any) => {
  // Return an action
  return {
    type: 'SONG_SELECTED',
    payload: song
  };
};