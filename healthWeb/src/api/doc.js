import request from '@/utils/request'

let path = "/doc"

export function login(data){
    return request({
        url:path+'/login',
        method:'post',
        data
    })
}

export function loginAdmin(data){
    return request({
        url:path+'/loginAdmin',
        method:'post',
        data
    })
}

export function logon(data){
    return request({
        url:path+'/logon',
        method:'post',
        data
    })
}

export function getAppointmentList(data){
    return request({
        url:path+'/getAppointmentList',
        method:'post',
        data
    })
}

export function updateHealth(data){
    return request({
        url:path+'/updateHealth',
        method:'post',
        data
    })
}

export function getHealth(data){
    return request({
        url:path+'/getHealth',
        method:'post',
        data
    })
}

export function getDoc(data){
    return request({
        url:path+'/getDoc?docId='+data,
        method:'get',
    })
}

export function updateDoc(data){
    return request({
        url:path+'/updateDoc',
        method:'post',
        data
    })
}

export function getDocQua(data){
    return request({
        url:path+'/getDocQua?docId='+data,
        method:'get',
    })
}

export function updateDocQua(data){
    return request({
        url:path+'/updateDocQua',
        method:'post',
        data
    })
}

export function createKnowledge(data){
    return request({
        url:path+'/createKnowledge',
        method:'post',
        data
    })
}

export function getKnowledgeList(data){
    return request({
        url:path+'/getKnowledgeList',
        method:'post',
        data
    })
}

export function checkKnowledge(id){
    return request({
        url:path+'/checkKnowledge?id='+id,
        method:'get',
    })
}

export function updateKnowledge(id,status){
    return request({
        url:path+'/updateKnowledge?id='+id+'&status='+status,
        method:'get',
    })
}

export function getDocQuaList(){
    return request({
        url:path+'/getDocQuaList',
        method:'get',
    })
}