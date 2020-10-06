import React, { Component } from 'react'
import JobService from '../services/JobService.js';

class AddJobComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            job: '',
            product: '',
            branch: '',
            folder: '',
            schedule: '',
            subfolder: '',
            url: '',
            apiUrl: '',
            lastBuildApiUrl: '',
            active: ''
        }
        
        this.changeJobHandler = this.changeJobHandler.bind(this);
        this.changeProductHandler = this.changeProductHandler.bind(this);
        this.changeBranchHandler = this.changeBranchHandler.bind(this);
        this.changeFolderHandler = this.changeFolderHandler.bind(this);
        this.changeScheduleHandler = this.changeScheduleHandler.bind(this);
        this.changeSubfolderHandler = this.changeSubfolderHandler.bind(this);
        this.changeUrlHandler = this.changeUrlHandler.bind(this);
        this.changeApiUrlHandler = this.changeApiUrlHandler.bind(this);
        this.changeLastBuildApiUrlHandler = this.changeLastBuildApiUrlHandler.bind(this);
        this.changeActiveHandler = this.changeActiveHandler.bind(this);

        this.saveOrUpdateJob = this.saveOrUpdateJob.bind(this);
    }

    componentDidMount(){

        if(this.state.id === '_add'){
            return
        }else{
            JobService.getJobById(this.state.id).then( (res) =>{
                let job = res.data;
                this.setState({job: job.job,
                    product: job.product,
                    branch: job.branch,
                    folder: job.folder,
                    schedule: job.schedule,
                    subfolder: job.subfolder,
                    url: job.url,
                    apiUrl: job.apiUrl,
                    lastBuildApiUrl: job.lastBuildApiUrl,
                    active: job.active
                });
            });
        }        
    }

    saveOrUpdateJob = (e) => {
        e.preventDefault();
        let job = {job: this.state.job,
                   product: this.state.product,
                   branch: this.state.branch,
                   folder: this.state.folder,
                   schedule: this.state.schedule,
                   subfolder: this.state.subfolder,
                   url: this.state.url,
                   apiUrl: this.state.apiUrl,
                   lastBuildApiUrl: this.state.lastBuildApiUrl,
                   active: this.state.active};

        console.log('job => ' + JSON.stringify(job));

        if(this.state.id === '_add'){
            JobService.addJob(job).then(res =>{
                this.props.history.push('/jobs');
            });
        }else{
            JobService.updateJob(job, this.state.id).then( res => {
                this.props.history.push('/jobs');
            });
        }
    }
    
    changeJobHandler= (event) => {
        this.setState({job: event.target.value});
    }

    changeProductHandler= (event) => {
        this.setState({product: event.target.value});
    }

    changeBranchHandler= (event) => {
        this.setState({branch: event.target.value});
    }

    changeFolderHandler= (event) => {
        this.setState({folder: event.target.value});
    }

    changeScheduleHandler= (event) => {
        this.setState({schedule: event.target.value});
    }

    changeSubfolderHandler= (event) => {
        this.setState({subfolder: event.target.value});
    }

    changeUrlHandler= (event) => {
        this.setState({url: event.target.value});
    }

    changeApiUrlHandler= (event) => {
        this.setState({apiUrl: event.target.value});
    }

    changeLastBuildApiUrlHandler= (event) => {
        this.setState({lastBuildApiUrl: event.target.value});
    }

    changeActiveHandler= (event) => {
        this.setState({active: event.target.value});
    }

    cancel(){
        this.props.history.push('/jobs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Job</h3>
        }else{
            return <h3 className="text-center">Update Job</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Job: </label>
                                            <input placeholder="Job" name="job" className="form-control" 
                                                value={this.state.job} onChange={this.changeJobHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label> Product: </label>
                                            <input placeholder="Product" name="product" className="form-control" 
                                                value={this.state.product} onChange={this.changeProductHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label> Branch: </label>
                                            <input placeholder="Branch" name="branch" className="form-control" 
                                                value={this.state.branch} onChange={this.changeBranchHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label> Folder: </label>
                                            <input placeholder="Folder" name="folder" className="form-control" 
                                                value={this.state.folder} onChange={this.changeFolderHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label> Schedule: </label>
                                            <input placeholder="Schedule" name="schedule" className="form-control" 
                                                value={this.state.schedule} onChange={this.changeScheduleHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label> Subfolder: </label>
                                            <input placeholder="Subfolder" name="subfolder" className="form-control" 
                                                value={this.state.subfolder} onChange={this.changeSubfolderHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label> Url: </label>
                                            <input placeholder="Url" name="url" className="form-control" 
                                                value={this.state.url} onChange={this.changeUrlHandler}/>
                                        </div>     
                                        
                                        <div className = "form-group">
                                            <label> Api Url: </label>
                                            <input placeholder="ApiUrl" name="apiUrl" className="form-control" 
                                                value={this.state.apiUrl} onChange={this.changeApiUrlHandler}/>
                                        </div>                                   

                                        <div className = "form-group">
                                            <label> Last Build Api Url: </label>
                                            <input placeholder="LastBuildApiUrl" name="lastBuildApiUrl" className="form-control" 
                                                value={this.state.lastBuildApiUrl} onChange={this.changeLastBuildApiUrlHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label> Active: </label>
                                            <input placeholder="Active" name="active" className="form-control" 
                                                value={this.state.active} onChange={this.changeActiveHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateJob}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default AddJobComponent

