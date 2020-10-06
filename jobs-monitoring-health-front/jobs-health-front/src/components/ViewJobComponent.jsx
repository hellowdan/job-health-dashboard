import React, { Component } from 'react'
import JobService from '../services/JobService.js'

class ViewJobComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            job: {}
        }
    }

    componentDidMount(){
        JobService.getJobById(this.state.id).then( res => {
            this.setState({job: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Job Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Job: </label>
                            <div> { this.state.job.job }</div>
                        </div>

                        <div className = "row">
                            <label> Product: </label>
                            <div> { this.state.job.product }</div>
                        </div>

                        <div className = "row">
                            <label> Branch: </label>
                            <div> { this.state.job.branch }</div>
                        </div>

                        <div className = "row">
                            <label> Folder: </label>
                            <div> { this.state.job.folder }</div>
                        </div>

                        <div className = "row">
                            <label> Schedule: </label>
                            <div> { this.state.job.schedule }</div>
                        </div>

                        <div className = "row">
                            <label> Subfolder: </label>
                            <div> { this.state.job.subfolder }</div>
                        </div>

                        <div className = "row">
                            <label> Url: </label>
                            <div> { this.state.job.url }</div>
                        </div>

                        <div className = "row">
                            <label> Api Url: </label>
                            <div> { this.state.job.apiUrl }</div>
                        </div>

                        <div className = "row">
                            <label> Last Build Api Url: </label>
                            <div> { this.state.job.lastBuildApiUrl }</div>
                        </div>                        

                        <div className = "row">
                            <label> Active: </label>
                            <div> { this.state.job.active }</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewJobComponent

