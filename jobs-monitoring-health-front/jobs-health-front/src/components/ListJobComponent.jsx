import React, { Component } from 'react'
import JobService from '../services/JobService'

class ListJobComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                jobs: []
        }
        this.addJob = this.addJob.bind(this);
        // this.editJob = this.editJob.bind(this);
        // this.deleteJob = this.deleteJob.bind(this);
    }

    // deleteJob(id){
    //     JobService.deleteJob(id).then( res => {
    //         this.setState({jobs: this.state.jobs.filter(job => job.id !== id)});
    //     });
    // }

    viewJob(id){
        this.props.history.push(`/view-job/${id}`);
    }
    
    // editJob(id){
    //     this.props.history.push(`/add-job/${id}`);
    // }

    componentDidMount(){
        JobService.getJobs().then((res) => {
            this.setState({ jobs: res.data});
        });
    }

    addJob(){
        this.props.history.push('/add-job/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Jobs List</h2>
                 <div className = "row">
                    <button className="btn btn-primary" onClick={this.addJob}> Add Job</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Job</th>
                                    <th> Product</th>
                                    <th> Branch</th>
                                    <th> Folder</th>
                                    <th> Schedule</th>
                                    <th> Subfolder</th>
                                    <th> Url</th>
                                    <th> Api Url</th>
                                    <th> Last Build Api Url</th>
                                    <th> Active</th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.jobs.map(
                                        job => 
                                        <tr key = {job.id}>
                                             <td> {job.job}</td>
                                             <td> {job.product}</td>
                                             <td> {job.branch}</td>
                                             <td> {job.folder}</td>
                                             <td> {job.schedule}</td>
                                             <td> {job.subfolder}</td>
                                             <td> {job.url}</td>
                                             <td> {job.apiUrl}</td>
                                             <td> {job.lastBuildApiUrl}</td>
                                             <td> {job.active}</td>
                                             <td>
                                                 {/* <button onClick={ () => this.editJob(job.id)} className="btn btn-info">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteJob(job.id)} className="btn btn-danger">Delete </button> */}
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewJob(job.id)} className="btn btn-info">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListJobComponent