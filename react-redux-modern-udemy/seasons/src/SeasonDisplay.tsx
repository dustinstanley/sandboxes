import './SeasonDisplay.css'
import React from 'react';

interface SeasonConfig {
  text: string,
  iconName: string
}

interface SeasonsConfig {
  [propName: string]: SeasonConfig    // this is an example of a TypeScript "index signature"
}

const seasonConfig = {
  summer: {
    text: 'Lets hit the beach!',
    iconName: 'sun'
  },
  winter: {
    text: 'Brrr it is cold!',
    iconName: 'snowflake'
  }
} as SeasonsConfig;


export default class SeasonDisplay extends React.Component<SeasonDisplayProps, any> {
  constructor(props: SeasonDisplayProps) {
    super(props);
    this.state = {};
  }

  getSeason = (lat: Number | null, month: Number | null) : string => {
    if (lat == null || month == null) {
      return 'Loading...';
    }
    if (month > 2 && month < 9) {
      return lat > 0 ? 'summer' : 'winter';
    } else {
      return lat > 0 ? 'winter' : 'summer';
    }
  };

  render() {
    const season = this.getSeason(this.props.lat, new Date().getMonth());
    const {text, iconName} = seasonConfig[season];  // this is an example of "object destructuring"

    return (
        <div className={`season-display ${season}`}>
          <i className={`icon-left massive ${iconName} icon`} />
          <h1>{text}</h1>
          <i className={`icon-right massive ${iconName} icon`} />
        </div>
    );
  }
}

interface SeasonDisplayProps {
  lat: Number | null
}