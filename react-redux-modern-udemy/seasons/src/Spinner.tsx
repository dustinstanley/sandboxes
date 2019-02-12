import React from 'react';

interface SpinnerProps {
  messageText: string
}

const Spinner = (props: SpinnerProps) => {
  return (
    <div className={"ui active dimmer"}>
      <div className={"ui big text loader"}>{props.messageText}</div>
    </div>
  )
};

Spinner.defaultProps = {
  messageText: "Loading..."
};

export default Spinner;