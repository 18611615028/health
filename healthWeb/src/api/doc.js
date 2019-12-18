import request from '@/utils/request'

let path = "/doc"

export function login(data){
    return request({
        url:path+'/login',
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